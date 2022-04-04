package com.item;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestMapper testMapper;

    @Override
    public List<portfolio> getAllDataList() {
        return testMapper.getAllDataList();
    }
}