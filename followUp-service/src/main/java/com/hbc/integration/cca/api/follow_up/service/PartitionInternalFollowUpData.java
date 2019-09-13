//package com.hbc.integration.cca.api.follow_up.service;
//
//
//import java.util.AbstractList;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.Collectors;
//
//public final class PartitionInternalFollowUpData<T> extends AbstractList<List<T>> {
//
//    private final List<T> list;
//    private final int chunkSize;
//
//    public PartitionInternalFollowUpData(List<T> list) {
//        this.list = new ArrayList<>(list);
//        this.chunkSize = 1000;
//    }
//
//    public static <T> PartitionInternalFollowUpData<T> ofSize(List<T> list) {
//        return new PartitionInternalFollowUpData<>(list);
//    }
//
//    @Override
//    public List<T> get(int index) {
//        int start = index * chunkSize;
//        int end = Math.min(start + chunkSize, list.size());
//
//        if (start > end) {
//            throw new IndexOutOfBoundsException("Index " + index + " is out of the list range <0," + (size() - 1) + ">");
//        }
//
//        return new ArrayList<>(list.subList(start, end));
//    }
//
//    @Override
//    public int size() {
//        return (int) Math.ceil((double) list.size() / (double) chunkSize);
//    }
//}