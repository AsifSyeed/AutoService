package com.example.autoservice.global;

import com.example.autoservice.model.Car;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Car> booking;

    static {
        booking = new ArrayList<Car>();
    }
}
