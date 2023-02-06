/*
 * Copyright (c) 2023 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.test.map;

import java.util.Map;

import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.test.CollectionTestCase;
import org.eclipse.collections.test.RichIterableWithDuplicatesTestCase;
import org.junit.Test;

public interface MapTestCase extends CollectionTestCase
{
    @Override
    <K, V> Map<K, V> newWith(Object... elements);

    <K, V> MapIterable<K, V> newWithKeysValues(Object... elements);

    <T> MutableCollection<T> newMutableForFilter(T... elements);


    @Test
    default void Map_forEach()
    {
        MapIterable<Object, Integer> map = this.newWith(3, 3, 3, 2, 2, 1);
        MutableCollection<Integer> forEach = this.newMutableForFilter();
        map.forEach((key, value) -> forEach.add(value + 10));
        assertEquals(this.newMutableForFilter(13, 13, 13, 12, 12, 11), forEach);

        MapIterable<Integer, String> map2 = this.newWithKeysValues(3, "Three", 2, "Two", 1, "Three");
        MutableCollection<String> forEach2 = this.newMutableForFilter();
        map2.forEach((key, value) -> forEach2.add(key + value));
        assertEquals(this.newMutableForFilter("3Three", "2Two", "1Three"), forEach2);
    }
}
