package web.baemin.near.mapper;

import org.apache.ibatis.annotations.Mapper;
import web.baemin.near.dto.Address;

import java.util.List;

@Mapper
public interface NearMapper {

    List<Address> addressList();

}
