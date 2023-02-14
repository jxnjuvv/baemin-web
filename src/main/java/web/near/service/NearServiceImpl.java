package web.baemin.near.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import web.baemin.near.dto.Address;
import web.baemin.near.mapper.NearMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NearServiceImpl implements NearService {


    private final NearMapper nearMapper; // MyBatis. Mapper

    @Override
    public List<Address> addressList() {
        return nearMapper.addressList();
    }

}
