/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.udacity.shahd.habittracker.data;

import android.provider.BaseColumns;

/**
 * API Contract for the habits tracker app.
 */
public final class HabitContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private HabitContract() {
    }

    /**
     * Inner class that defines constant values for the habits database table.
     * Each entry in the table represents a single habit.
     */
    public static final class HabitsEntry implements BaseColumns {

        /**
         * Name of database table for habits
         */
        public final static String TABLE_NAME = "habits";

        /**
         * Unique ID number for the habit (only for use in the database table).
         * <p>
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the habit.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_HABIT_NAME = "name";

        /**
         * habit duration in minutes
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_HABIT_DURATION = "duration";

        /**
         * Day of habits.
         * <p>
         * The only possible values are {@link #SATURDAY}, {@link #SUNDAY}, {@link #MONDAY}, {@link #TUESDAY},, {@link #WEDNESDAY}, {@link #THURSDAY}
         * or {@link #FRIDAY}.
         * <p>
         * Type: INTEGER
         */
        public final static String COLUMN_HABIT_DAY = "day";


        /**
         * Possible values of days.
         */
        public static final int SATURDAY = 0;
        public static final int SUNDAY = 1;
        public static final int MONDAY = 2;
        public static final int TUESDAY = 3;
        public static final int WEDNESDAY = 4;
        public static final int THURSDAY = 5;
        public static final int FRIDAY = 6;
    }

}

