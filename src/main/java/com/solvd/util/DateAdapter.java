package com.solvd.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter <String, Date>{

    @Override
    public String marshal(Date d) throws Exception {
        return new SimpleDateFormat("dd/mm/yyyy").format(d);
    }
    @Override
    public Date unmarshal(String d) throws Exception {
        return new SimpleDateFormat("dd/mm/yyyy").parse(d);
    }
}
