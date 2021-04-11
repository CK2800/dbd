package dk.ck.learnedma.generated.valuedomains.impl;

import dk.ck.learnedma.generated.valuedomains.JObject;
import dk.ck.learnedma.generated.valuedomains.OBJECTS;
import dk.ck.learnedma.generated.valuedomains.OBJECTS.OBJECTSBuilder;
import java.util.ArrayList;
import org.abstractica.edma.valuedomains.IValueInstance;

/**
 * 
 */
public class OBJECTSBuilderImpl implements OBJECTSBuilder
{
    private ArrayList<Object> valueList;



    /**
     * Constructor
     */
    public OBJECTSBuilderImpl()
    {
        valueList = new ArrayList<Object>();
    }

    /**
     * Adds an element to the list
     * @param jObject  The element to be added to the list
     * @return         An interface to the builder for chaining method calls
     */
    public OBJECTSBuilder add(JObject jObject)
    {
        if(jObject == null) throw new NullPointerException();
        valueList.add(((IValueInstance) jObject).edma_getValue());
        return this;
    }

    /**
     * Builds the list with the added elements
     * @return  The builded list
     */
    public OBJECTS end()
    {
        Object[] res = new Object[valueList.size()];
        int pos = 0;
        for(Object o : valueList)
        {
            res[pos++] = o;
        }
        return new OBJECTSImpl(OBJECTSImpl.edma_create(res));
    }
}
