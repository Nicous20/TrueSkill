package Dao;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter@Getter
@JSONType(orders={"Attr","Item1","Item2","Res"})
public class Comparison {
    private String Attr;
    private String Item1;
    private String Item2;
    private String Res;
}
