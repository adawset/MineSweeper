package andy.zhu.minesweeper

import android.app.Application
import mineAndroidApp

class MineApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        mineAndroidApp = this
    }

    companion object {
        lateinit var instance: MineApplication
            private set
    }
}