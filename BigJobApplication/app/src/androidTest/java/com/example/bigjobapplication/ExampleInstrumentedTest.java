package com.example.bigjobapplication;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.bigjobapplication.utils.SolarDao;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private SolarDao solarDao;

    @Test
    public void testInsert() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        solarDao = new SolarDao(context);
        solarDao.insert();
    }

    @Test
    public void testUpdate() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        solarDao = new SolarDao(context);
        solarDao.update();
    }

    @Test
    public void testQuery() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        solarDao = new SolarDao(context);
        solarDao.query();
    }

    @Test
    public void testDelete() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        solarDao = new SolarDao(context);
        solarDao.delete();
    }
}