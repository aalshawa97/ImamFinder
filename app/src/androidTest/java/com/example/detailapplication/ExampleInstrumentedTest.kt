package com.example.detailapplication

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

//import org.junit.Assert.assertNotEquals


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.detailapplication", appContext.packageName)
    }

    @Test
    fun useContext(){
        val context = InstrumentationRegistry.getInstrumentation().context
        Log.d("Context", "use: " + context)
        assertEquals(InstrumentationRegistry.getInstrumentation().context, context)
    }

    /*
    @Test
    fun notNullAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        //assertThat(appContext, null)
        assertNotEquals(null, appContext.packageName)
    }

    @Test
    fun useNotAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertNotEquals("Random", appContext.packageName)
    }
    */
}