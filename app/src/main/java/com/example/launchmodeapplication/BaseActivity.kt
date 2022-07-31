package com.example.launchmodeapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {

    protected var activityManager: ActivityManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (activityManager == null) {
            activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        }
    }

    open fun startActivity(activity: Activity?, targetActivityClass: Class<*>?) {
        val intent = Intent(activity, targetActivityClass)
        startActivity(intent)
    }

    @SuppressLint("NewApi")
    protected open fun getNumberOfTasks(): Int {
        return activityManager!!.appTasks.size
    }

    // Display the root Activity of task-stack
    open fun appTaskState(): String{

            val stringBuilder = StringBuilder()
            val totalNumberOfTasks =
                activityManager!!.getRunningTasks(10).size //Returns total number of tasks - stacks
            stringBuilder.append("\nTotal Number of Tasks: $totalNumberOfTasks\n\n")
            val taskInfo =
                activityManager!!.getRunningTasks(10) //returns List of RunningTaskInfo - corresponding to tasks - stacks
            for (info in taskInfo) {
                stringBuilder.append(
                    """
                               Task Id: ${info.id}, Number of Activities : ${info.numActivities}
                               
                               """.trimIndent()
                ) //Number of Activities in task - stack

                // Display the root Activity of task-stack
                stringBuilder.append(
                    """
                               TopActivity: ${
                        info.topActivity!!.className.replace(
                            "lauchmodesdemo.youtube.codetutor.com.activitylauchmodesdemo.",
                            ""
                        )
                    }
                               
                               """.trimIndent()
                )

                // Display the top Activity of task-stack
                stringBuilder.append(
                    """ BaseActivity:${
                        info.baseActivity!!.className.replace(
                            "lauchmodesdemo.youtube.codetutor.com.activitylauchmodesdemo.",
                            ""
                        )
                    }
                               
                               """.trimIndent()
                )
                stringBuilder.append("\n\n")
            }
            return stringBuilder.toString()
        }

}