package web.baemin.main.mapper;

import org.apache.ibatis.annotations.Mapper;
import web.baemin.main.dto.StoreType;

import java.util.List;

@Mapper
public interface MainMapper {

    List<StoreType> storeTypeList();

}
