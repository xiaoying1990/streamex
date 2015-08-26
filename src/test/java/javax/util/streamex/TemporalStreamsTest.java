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

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author Tagir Valeev
 *
 */
public class TemporalStreamsTest {
    @Test
    public void testDays() {
        List<LocalDate> expected = Arrays.asList(LocalDate.of(2015, 1, 10), LocalDate.of(2015, 1, 11),
            LocalDate.of(2015, 1, 12), LocalDate.of(2015, 1, 13), LocalDate.of(2015, 1, 14));
        assertEquals(expected, TemporalStreams.days(LocalDate.of(2015, 1, 10), LocalDate.of(2015, 1, 15)).toList());
        assertEquals(expected, TemporalStreams.daysInclusive(LocalDate.of(2015, 1, 10), LocalDate.of(2015, 1, 14)).toList());
        TemporalStreams.yearDays(Year.of(2015)).forEach(System.out::println);
    }
}
