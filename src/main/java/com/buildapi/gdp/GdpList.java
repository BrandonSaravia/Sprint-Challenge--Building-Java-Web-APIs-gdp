package com.buildapi.gdp;

import com.buildapi.CheckGDP;
import com.buildapi.gdp.model.GDP;

import java.util.ArrayList;

public class GdpList {
    public ArrayList<GDP> gdpList = new ArrayList<GDP>();

    public GdpList() {
        gdpList.add(new GDP("United States","20513000"));
        gdpList.add(new GDP("China","13457267"));
        gdpList.add(new GDP("Japan","5070626"));
        gdpList.add(new GDP("Germany","4029140"));
        gdpList.add(new GDP("United Kingdom","2808899"));
        gdpList.add(new GDP("France","2794696"));
        gdpList.add(new GDP("India","2689992"));
        gdpList.add(new GDP("Italy","2086911"));
        gdpList.add(new GDP("Brazil","1909386"));
        gdpList.add(new GDP("Canada","1733706"));
        gdpList.add(new GDP("South Korea","1655608"));
        gdpList.add(new GDP("Russia","1576488"));
        gdpList.add(new GDP("Spain","1437047"));
        gdpList.add(new GDP("Australia","1427767"));
        gdpList.add(new GDP("Mexico","1199264"));
        gdpList.add(new GDP("Indonesia","1005268"));
        gdpList.add(new GDP("Netherlands","909887"));
        gdpList.add(new GDP("Saudi Arabia","769878"));
        gdpList.add(new GDP("Turkey","713513"));
        gdpList.add(new GDP("Switzerland","709118"));
        gdpList.add(new GDP("Taiwan","602678"));
        gdpList.add(new GDP("Sweden","554659"));
        gdpList.add(new GDP("Poland","549478"));
        gdpList.add(new GDP("Belgium","536055"));
        gdpList.add(new GDP("Thailand","490120"));
        gdpList.add(new GDP("Argentina","475429"));
        gdpList.add(new GDP("Austria","459401"));
        gdpList.add(new GDP("Norway","441439"));
        gdpList.add(new GDP("United Arab Emirates","432612"));
        gdpList.add(new GDP("Iran","430082"));
        gdpList.add(new GDP("Nigeria","397472"));
        gdpList.add(new GDP("South Africa","376679"));
        gdpList.add(new GDP("Ireland","366448"));
        gdpList.add(new GDP("Israel","365599"));
        gdpList.add(new GDP("Hong Kong","360315"));
        gdpList.add(new GDP("Denmark","354683"));
        gdpList.add(new GDP("Malaysia","347290"));
        gdpList.add(new GDP("Singapore","346621"));
        gdpList.add(new GDP("Colombia","336940"));
        gdpList.add(new GDP("Philippines","331678"));
        gdpList.add(new GDP("Pakistan","306987"));
        gdpList.add(new GDP("Chile","299887"));
        gdpList.add(new GDP("Bangladesh","286275"));
        gdpList.add(new GDP("Finland","276553"));
        gdpList.add(new GDP("Egypt","249471"));
        gdpList.add(new GDP("Czech Republic","244540"));
        gdpList.add(new GDP("Vietnam","241434"));
        gdpList.add(new GDP("Romania","239440"));
        gdpList.add(new GDP("Portugal","237962"));
        gdpList.add(new GDP("Iraq","230911"));
        gdpList.add(new GDP("Peru","228944"));
        gdpList.add(new GDP("Greece","218057"));
        gdpList.add(new GDP("New Zealand","205997"));
        gdpList.add(new GDP("Algeria","188342"));
        gdpList.add(new GDP("Qatar","188295"));
        gdpList.add(new GDP("Kazakhstan","184209"));
        gdpList.add(new GDP("Hungary","156393"));
        gdpList.add(new GDP("Kuwait","144523"));
        gdpList.add(new GDP("Ukraine","126390"));
        gdpList.add(new GDP("Morocco","118178"));
        gdpList.add(new GDP("Angola","114504"));
        gdpList.add(new GDP("Ecuador","107266"));
        gdpList.add(new GDP("Slovakia","106940"));
        gdpList.add(new GDP("Puerto Rico","104557"));
        gdpList.add(new GDP("Venezuela","96328"));
        gdpList.add(new GDP("Sri Lanka","92504"));
        gdpList.add(new GDP("Kenya","89591"));
        gdpList.add(new GDP("Ethiopia","83836"));
        gdpList.add(new GDP("Oman","81682"));
        gdpList.add(new GDP("Dominican Republic","81103"));
        gdpList.add(new GDP("Guatemala","79109"));
        gdpList.add(new GDP("Syria","77460"));
        gdpList.add(new GDP("Myanmar","71543"));
        gdpList.add(new GDP("Luxembourg","68993"));
        gdpList.add(new GDP("Panama","66031"));
        gdpList.add(new GDP("Bulgaria","63651"));
        gdpList.add(new GDP("Uruguay","60933"));
        gdpList.add(new GDP("Costa Rica","60816"));
        gdpList.add(new GDP("Croatia","59971"));
        gdpList.add(new GDP("Belarus","56934"));
        gdpList.add(new GDP("Lebanon","56709"));
        gdpList.add(new GDP("Tanzania","55645"));
        gdpList.add(new GDP("Slovenia","54969"));
        gdpList.add(new GDP("Macau","53961"));
        gdpList.add(new GDP("Lithuania","52468"));
        gdpList.add(new GDP("Ghana","51815"));
        gdpList.add(new GDP("Serbia","47564"));
        gdpList.add(new GDP("Cote d'Ivoire","45875"));
        gdpList.add(new GDP("Azerbaijan","45592"));
        gdpList.add(new GDP("Uzbekistan","43303"));
        gdpList.add(new GDP("Libya","43236"));
        gdpList.add(new GDP("Democratic Republic of the Congo","42692"));
        gdpList.add(new GDP("Turkmenistan","42764"));
        gdpList.add(new GDP("Jordan","41869"));
        gdpList.add(new GDP("Paraguay","41851"));
        gdpList.add(new GDP("Bolivia","41833"));
        gdpList.add(new GDP("Tunisia","41662"));
        gdpList.add(new GDP("Bahrain","39300"));
        gdpList.add(new GDP("Cameroon","38445"));
        gdpList.add(new GDP("Latvia","34286"));
        gdpList.add(new GDP("Sudan","33249"));
    }

    public GDP findGDP(CheckGDP tester)
    {
        for (GDP i : gdpList)
        {
            if (tester.test(i))
            {
                return i;
            }
        }
        return null;
    }

    public ArrayList<GDP> findGDPs(CheckGDP tester)
    {
        ArrayList<GDP> tempGDPList = new ArrayList<>();

        for (GDP d : gdpList)
        {
            if (tester.test(d))
            {
                tempGDPList.add(d);
            }
        }

        return tempGDPList;
    }
}
