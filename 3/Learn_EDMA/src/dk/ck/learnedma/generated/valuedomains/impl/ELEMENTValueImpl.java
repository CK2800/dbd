package dk.ck.learnedma.generated.valuedomains.impl;

import dk.ck.learnedma.generated.valuedomains.ELEMENTValue;
import dk.ck.learnedma.generated.valuedomains.JObject;
import dk.ck.learnedma.generated.valuedomains.JSONBoolean;
import dk.ck.learnedma.generated.valuedomains.JSONFloat;
import dk.ck.learnedma.generated.valuedomains.JSONNull;
import dk.ck.learnedma.generated.valuedomains.JSONNumber;
import dk.ck.learnedma.generated.valuedomains.JSONString;
import dk.ck.learnedma.generated.valuedomains.OBJECTS;
import dk.ck.learnedma.generated.valuedomains.external.EDMA_ExternalConstraints;
import dk.ck.learnedma.generated.valuedomains.impl.JObjectImpl;
import dk.ck.learnedma.generated.valuedomains.impl.JSONBooleanImpl;
import dk.ck.learnedma.generated.valuedomains.impl.JSONFloatImpl;
import dk.ck.learnedma.generated.valuedomains.impl.JSONNullImpl;
import dk.ck.learnedma.generated.valuedomains.impl.JSONNumberImpl;
import dk.ck.learnedma.generated.valuedomains.impl.JSONStringImpl;
import dk.ck.learnedma.generated.valuedomains.impl.OBJECTSImpl;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.IValueInstance;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;

/**
 * The implementation of ELEMENTValue
 */
public class ELEMENTValueImpl extends ELEMENTValue implements IValueInstance
{
    private int edma_hash;
    private Object[] value;



    /**
     * Check if a value is valid
     * @param value  The value to validate
     */
    public static void edma_validate(Object value) throws InvalidValueException
    {
        edma_domain.validate(value, EDMA_ExternalConstraints.instance);
    }

    /**
     * create value without checking
     * @param value  The value to check and create
     * @return       <tt>true</tt> The new created value
     */
    public static Object edma_create(Object value)
    {
        return edma_domain.newValue(value);
    }

    /**
     * Constructor
     * @param o  The Object that represents this OneOf value
     */
    public ELEMENTValueImpl(Object o)
    {
        edma_hash = 0;
        value = (Object[]) o;
    }

    /**
     * Gets the value domain for this value instance
     * @return  The value domain for this value instance
     */
    public IMetaValueDomain edma_getDomain()
    {
        return edma_domain;
    }

    /**
     * Access to the general Object value
     * @return  The value as a general Object
     */
    public Object edma_getValue()
    {
        return value;
    }

    /**
     * Returns <tt>true</tt> if this value equals the given value
     * @param o  Object to test equality with
     * @return   <tt>true</tt> if this value equals the given value
     */
    public boolean equals(Object o)
    {
        if(!(o instanceof IValueInstance)) return false;
        IValueInstance inst = (IValueInstance) o;
        if(8 != inst.edma_getDomain().getIndex()) return false;
        return edma_domain.valueEqual(value, inst.edma_getValue());
    }

    /**
     * Gets the value hash for this value instance
     * @return  The hash for this value instance
     */
    public int hashCode()
    {
        if(edma_hash == 0) edma_hash = edma_domain.valueHashCode(value);
        return edma_hash;
    }

    /**
     * Returns this value instance as a string
     * @return  this value instance as a string
     */
    public String toString()
    {
        return edma_domain.valueToString(value);
    }

    /**
     * Compare this ELEMENTValue to another ELEMENTValue
     * @param eLEMENTValue  The ELEMENTValue to compare with
     * @return              A negative integer, zero, or a positive integer as
     *                      this ELEMENTValue is less than, equal to, or greater
     *                      than the specified ELEMENTValue
     */
    public int compareTo(ELEMENTValue eLEMENTValue)
    {
        return edma_domain.valueCompare(value, ((ELEMENTValueImpl) eLEMENTValue).value);
    }

    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public void toStream(DataOutput out) throws IOException
    {
        edma_domain.writeValue(((IValueInstance) this).edma_getValue(), out);
    }

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * OBJECTS
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          OBJECTS
     */
    public boolean isOBJECTS()
    {
        Integer index = (Integer) value[0];
        return (index.intValue() == 0);
    }

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * JObject
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          JObject
     */
    public boolean isJObject()
    {
        Integer index = (Integer) value[0];
        return (index.intValue() == 1);
    }

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * JSONString
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          JSONString
     */
    public boolean isJSONString()
    {
        Integer index = (Integer) value[0];
        return (index.intValue() == 2);
    }

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * JSONNumber
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          JSONNumber
     */
    public boolean isJSONNumber()
    {
        Integer index = (Integer) value[0];
        return (index.intValue() == 3);
    }

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * JSONFloat
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          JSONFloat
     */
    public boolean isJSONFloat()
    {
        Integer index = (Integer) value[0];
        return (index.intValue() == 4);
    }

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * JSONBoolean
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          JSONBoolean
     */
    public boolean isJSONBoolean()
    {
        Integer index = (Integer) value[0];
        return (index.intValue() == 5);
    }

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * JSONNull
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          JSONNull
     */
    public boolean isJSONNull()
    {
        Integer index = (Integer) value[0];
        return (index.intValue() == 6);
    }

    /**
     * Returns this value as a value from the value domain OBJECTS or throws an
     * UnsupportedOperationException if this value is not from the value domain
     * OBJECTS
     * @return  This value as a value from the value domain OBJECTS
     */
    public OBJECTS asOBJECTS()
    {
        Integer index = (Integer) value[0];
        if(index.intValue() != 0) throw new UnsupportedOperationException();
        return new OBJECTSImpl(value[1]);
    }

    /**
     * Returns this value as a value from the value domain JObject or throws an
     * UnsupportedOperationException if this value is not from the value domain
     * JObject
     * @return  This value as a value from the value domain JObject
     */
    public JObject asJObject()
    {
        Integer index = (Integer) value[0];
        if(index.intValue() != 1) throw new UnsupportedOperationException();
        return new JObjectImpl(value[1]);
    }

    /**
     * Returns this value as a value from the value domain JSONString or throws
     * an UnsupportedOperationException if this value is not from the value
     * domain JSONString
     * @return  This value as a value from the value domain JSONString
     */
    public JSONString asJSONString()
    {
        Integer index = (Integer) value[0];
        if(index.intValue() != 2) throw new UnsupportedOperationException();
        return new JSONStringImpl(value[1]);
    }

    /**
     * Returns this value as a value from the value domain JSONNumber or throws
     * an UnsupportedOperationException if this value is not from the value
     * domain JSONNumber
     * @return  This value as a value from the value domain JSONNumber
     */
    public JSONNumber asJSONNumber()
    {
        Integer index = (Integer) value[0];
        if(index.intValue() != 3) throw new UnsupportedOperationException();
        return new JSONNumberImpl(value[1]);
    }

    /**
     * Returns this value as a value from the value domain JSONFloat or throws
     * an UnsupportedOperationException if this value is not from the value
     * domain JSONFloat
     * @return  This value as a value from the value domain JSONFloat
     */
    public JSONFloat asJSONFloat()
    {
        Integer index = (Integer) value[0];
        if(index.intValue() != 4) throw new UnsupportedOperationException();
        return new JSONFloatImpl(value[1]);
    }

    /**
     * Returns this value as a value from the value domain JSONBoolean or
     * throws an UnsupportedOperationException if this value is not from the
     * value domain JSONBoolean
     * @return  This value as a value from the value domain JSONBoolean
     */
    public JSONBoolean asJSONBoolean()
    {
        Integer index = (Integer) value[0];
        if(index.intValue() != 5) throw new UnsupportedOperationException();
        return new JSONBooleanImpl(value[1]);
    }

    /**
     * Returns this value as a value from the value domain JSONNull or throws
     * an UnsupportedOperationException if this value is not from the value
     * domain JSONNull
     * @return  This value as a value from the value domain JSONNull
     */
    public JSONNull asJSONNull()
    {
        Integer index = (Integer) value[0];
        if(index.intValue() != 6) throw new UnsupportedOperationException();
        return new JSONNullImpl(value[1]);
    }
}
