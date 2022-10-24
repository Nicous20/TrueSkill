package Dao;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString@Setter@Getter
@JSONType(orders = {"res","attr"})
public class Res {
    private String res;
    private String attr;
}
