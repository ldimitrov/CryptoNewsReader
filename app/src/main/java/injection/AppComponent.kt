package injection

import dagger.Component

@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    // activities will be added here
}
