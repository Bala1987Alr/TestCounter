package com.example.balasubramanianmurge.testcounter

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    val MY_PREFERENCE="com.ibmbam.testcounter";
    val key_data="COUNT";
    var prefernces_data : SharedPreferences?= null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefernces_data= this.getSharedPreferences(MY_PREFERENCE,Context.MODE_PRIVATE)
        var count_data=prefernces_data!!.getInt(key_data,0)

        if(count_data!=null && count_data !=0)
            sample_text.text = count_data.toString()
        else
            sample_text.text = "0"

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun countFromJNI(count_data : Int ): Int
    external fun staticcountFromJNI() : Int

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")

        }
    }
    fun staticCount(view: View)
    {
        textView.text=staticcountFromJNI().toString()
    }

    fun count(view: View) {
        // Do something in response to button

        var countData=prefernces_data!!.getInt(key_data,0)
        val editor = prefernces_data!!.edit()

        Log.d("countData :", countData.toString())

        if(countData!=null && countData !=0)
        {
            editor.putInt(key_data,countData+1)
        }else
        {
            editor.putInt(key_data,1)
        }
        editor.apply()
        sample_text.text = countFromJNI(countData).toString()

    }
}
