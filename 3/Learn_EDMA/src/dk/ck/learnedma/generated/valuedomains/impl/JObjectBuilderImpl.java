package dk.ck.learnedma.generated.valuedomains.impl;

import dk.ck.learnedma.generated.valuedomains.ELEMENTS;
import dk.ck.learnedma.generated.valuedomains.JObject;
import dk.ck.learnedma.generated.valuedomains.JObject.JObjectBuilderElements;
import org.abstractica.edma.valuedomains.IValueInstance;

/**
 * 
 */
public class JObjectBuilderImpl implements JObjectBuilderElements
{
    private Object[] edma_value;



    /**
     * Constructor
     */
    public JObjectBuilderImpl()
    {
        edma_value = new Object[1];
    }

    /**
     * sets the elements field.
     * @param elements  The value to assign to the elements field
     * @return          The created JObject value
     */
    public JObject elements(ELEMENTS elements)
    {
        if(elements == null) throw new NullPointerException("The field elements in JObject may not be null");
        edma_value[0] = ((IValueInstance) elements).edma_getValue();
        return new JObjectImpl(JObjectImpl.edma_create(edma_value));
    }
}
