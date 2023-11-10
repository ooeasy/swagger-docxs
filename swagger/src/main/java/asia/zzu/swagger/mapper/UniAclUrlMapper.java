package asia.zzu.swagger.mapper;

import asia.zzu.swagger.model.UniAclUrl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UniAclUrlMapper extends BaseMapper<UniAclUrl> {
}
