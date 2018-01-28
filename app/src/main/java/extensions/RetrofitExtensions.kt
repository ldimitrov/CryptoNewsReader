package extensions

import android.util.Log
import kotlinx.coroutines.experimental.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


suspend fun <T> Call<T>.executeAsync(): T {
    return suspendCancellableCoroutine { continuation ->
        this.enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>?, t: Throwable) {
                continuation.resumeWithException(t)
            }

            override fun onResponse(call: Call<T>?, response: Response<T>?) {
                if (response != null) {
                    if (response.isSuccessful) {
                        continuation.resume(response.body()!!)
                    } else {
                        continuation.resumeWithException(retrofit2.HttpException(response))
                    }
                }
            }
        })

        continuation.invokeOnCompletion {
            if (continuation.isCancelled) {
                try {
                    cancel()
                } catch (e: Throwable) {
                    Log.d("RetrofitExtensions", "Something is wrong in RetrofitExtensions")
                }
            }
        }
    }
}