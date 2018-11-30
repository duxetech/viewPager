package com.duxetech.pager.events;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Karthik Swamy on 30-11-2018.
 */
public class eventBus{
    private static EventBus bus;
    public static EventBus getBus(){
        if(bus==null){
            bus = EventBus.getDefault();
            }
        return bus;

    }
}
