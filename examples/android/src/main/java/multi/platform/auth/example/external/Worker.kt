package multi.platform.auth.example.external

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class Worker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    override fun doWork(): Result {
        return Result.success()
    }
}
