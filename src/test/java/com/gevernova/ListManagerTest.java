package com.gevernova;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListManagerTest {
    private ListManager listManager;
    private List<Integer> list;
    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 10);
        assertTrue(list.contains(10));
    }
    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        ListManager.removeElement(list, 10);
        assertFalse(list.contains(10));
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals(2, ListManager.getSize(list));
    }
    @Test
    void testAddElementToNullList() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            listManager.addElement(null, 10);
        });
        assertEquals("Cannot invoke \"java.util.List.add(Object)\" because \"list\" is null", exception.getMessage());
    }

    @Test
    void testGetSizeOfNullList() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            listManager.getSize(null);
        });
        assertEquals("Cannot invoke \"java.util.List.size()\" because \"list\" is null", exception.getMessage());
    }
}
