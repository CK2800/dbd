package dk.ck.learnedma.generated.valuedomains.impl;

import dk.ck.learnedma.generated.valuedomains.ELEMENT;
import dk.ck.learnedma.generated.valuedomains.ELEMENTS;
import dk.ck.learnedma.generated.valuedomains.ELEMENTS.ELEMENTSBuilder;
import java.util.ArrayList;
import org.abstractica.edma.valuedomains.IValueInstance;

/**
 * 
 */
public class ELEMENTSBuilderImpl implements ELEMENTSBuilder
{
    private ArrayList<Object> valueList;



    /**
     * Constructor
     */
    public ELEMENTSBuilderImpl()
    {
        valueList = new ArrayList<Object>();
    }

    /**
     * Adds an element to the list
     * @param eLEMENT  The element to be added to the list
     * @return         An interface to the builder for chaining method calls
     */
    public ELEMENTSBuilder add(ELEMENT eLEMENT)
    {
        if(eLEMENT == null) throw new NullPointerException();
        valueList.add(((IValueInstance) eLEMENT).edma_getValue());
        return this;
    }

    /**
     * Builds the list with the added elements
     * @return  The builded list
     */
    public ELEMENTS end()
    {
        Object[] res = new Object[valueList.size()];
        int pos = 0;
        for(Object o : valueList)
        {
            res[pos++] = o;
        }
        return new ELEMENTSImpl(ELEMENTSImpl.edma_create(res));
    }
}
