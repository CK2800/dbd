package dk.ck.learnedma.generated.valuedomains.impl;

import dk.ck.learnedma.generated.valuedomains.ELEMENT;
import dk.ck.learnedma.generated.valuedomains.ELEMENT.ELEMENTBuilderKey;
import dk.ck.learnedma.generated.valuedomains.ELEMENT.ELEMENTBuilderValue;
import dk.ck.learnedma.generated.valuedomains.ELEMENTKey;
import dk.ck.learnedma.generated.valuedomains.ELEMENTValue;
import dk.ck.learnedma.generated.valuedomains.impl.ELEMENTKeyImpl;
import org.abstractica.edma.valuedomains.IValueInstance;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;

/**
 * 
 */
public class ELEMENTBuilderImpl implements ELEMENTBuilderKey, ELEMENTBuilderValue
{
    private Object[] edma_value;



    /**
     * Constructor
     */
    public ELEMENTBuilderImpl()
    {
        edma_value = new Object[2];
    }

    /**
     * sets the key field.
     * @param key  The value to assign to the key field
     * @return     Builder interface for setting the value field
     */
    public ELEMENTBuilderValue key(ELEMENTKey key)
    {
        if(key == null) throw new NullPointerException("The field key in ELEMENT may not be null");
        edma_value[0] = ((IValueInstance) key).edma_getValue();
        return this;
    }

    /**
     * sets the key field.
     * @param key  The value to assign to the key field
     * @return     Builder interface for setting the value field
     */
    public ELEMENTBuilderValue key(String key) throws InvalidValueException
    {
        if(key != null) ELEMENTKeyImpl.edma_validate(key);
        if(key == null) throw new NullPointerException();
        edma_value[0] = ELEMENTKeyImpl.edma_create(key);
        return this;
    }

    /**
     * sets the value field.
     * @param value  The value to assign to the value field
     * @return       The created ELEMENT value
     */
    public ELEMENT value(ELEMENTValue value)
    {
        if(value == null) throw new NullPointerException("The field value in ELEMENT may not be null");
        edma_value[1] = ((IValueInstance) value).edma_getValue();
        return new ELEMENTImpl(ELEMENTImpl.edma_create(edma_value));
    }
}
