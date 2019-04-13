package backend.converter;

import backend.house.model.HouseSale;

import java.util.List;

public class Converter {

    public Object[][] convertToObjectArray(List<HouseSale> data){

        Object[][] toReturn = new Object[data.size()][];

        for(int i = 0; i<data.size(); i++){
            toReturn[i] = data.get(i).getList();
        }

        return toReturn;
    }
}
