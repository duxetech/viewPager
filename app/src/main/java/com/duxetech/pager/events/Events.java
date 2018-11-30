package com.duxetech.pager.events;

/**
 * Created by Karthik Swamy on 30-11-2018.
 */
public class Events {

    public static class TabSelected {
        String msg;

        public String getMsg() {
            return msg;
        }

        public TabSelected(String msg) {

            this.msg = msg;
        }
    }
}
