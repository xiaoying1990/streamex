/*
 * Copyright 2015 Tagir Valeev
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package javax.util.streamex;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.ChronoField;

/**
 * @author Tagir Valeev
 *
 */
public class TemporalStreams {
    private TemporalStreams() {
        throw new UnsupportedOperationException();
    }
    
    private static StreamEx<LocalDate> daysRange(LocalDate from, int count) {
        return IntStreamEx.range(count).mapToObj(from::plusDays);
    }

    public static StreamEx<LocalDate> days(LocalDate fromInclusive, LocalDate toExclusive) {
        return daysRange(fromInclusive, fromInclusive.until(toExclusive).getDays());
    }
    
    public static StreamEx<LocalDate> daysInclusive(LocalDate fromInclusive, LocalDate toInclusive) {
        return daysRange(fromInclusive, fromInclusive.until(toInclusive).getDays()+1);
    }
    
    public static StreamEx<LocalDate> weekDays(LocalDate date) {
        return daysRange(date.with(ChronoField.DAY_OF_WEEK, 1), 7);
    }
    
    public static StreamEx<LocalDate> monthDays(LocalDate date) {
        return daysRange(date.withDayOfMonth(1), date.lengthOfMonth());
    }
    
    public static StreamEx<LocalDate> monthDays(YearMonth date) {
        return daysRange(date.atDay(1), date.lengthOfMonth());
    }
    
    public static StreamEx<LocalDate> yearDays(LocalDate date) {
        return daysRange(date.withDayOfYear(1), date.lengthOfYear());
    }
    
    public static StreamEx<LocalDate> yearDays(Year date) {
        return daysRange(date.atDay(1), date.length());
    }
}
