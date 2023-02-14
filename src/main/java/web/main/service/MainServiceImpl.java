package web.baemin.main.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import web.baemin.main.dto.StoreType;
import web.baemin.main.mapper.MainMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainServiceImpl implements MainService {


    private final MainMapper mainMapper; // MyBatis. Mapper

    @Override
    public List<StoreType> storeTypeList() {
        return mainMapper.storeTypeList();
    }



}
