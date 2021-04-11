package dk.ck.learnedma.generated.valuedomains;

import dk.ck.learnedma.generated.LearnEDMA;
import dk.ck.learnedma.generated.valuedomains.JObject;
import dk.ck.learnedma.generated.valuedomains.JSONBoolean;
import dk.ck.learnedma.generated.valuedomains.JSONFloat;
import dk.ck.learnedma.generated.valuedomains.JSONNull;
import dk.ck.learnedma.generated.valuedomains.JSONNumber;
import dk.ck.learnedma.generated.valuedomains.JSONString;
import dk.ck.learnedma.generated.valuedomains.OBJECTS;
import dk.ck.learnedma.generated.valuedomains.external.EDMA_ExternalConstraints;
import dk.ck.learnedma.generated.valuedomains.impl.ELEMENTValueImpl;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.IValueInstance;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: ELEMENTValue
 */
public abstract class ELEMENTValue implements Comparable<ELEMENTValue>
{
    protected static final IMetaValueDomain edma_domain = LearnEDMA.environment.getValueDomainDefinitions().getValueDomain(8);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The ELEMENTValue from the terminal
     */
    public static ELEMENTValue fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new ELEMENTValueImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The ELEMENTValue from the string representation
     */
    public static ELEMENTValue fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new ELEMENTValueImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The ELEMENTValue read from the stream
     */
    public static ELEMENTValue fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new ELEMENTValueImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The ELEMENTValue read from the stream
     */
    public static ELEMENTValue fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new ELEMENTValueImpl(res);
    }

    /**
     * Creates a new ELEMENTValue with the internal value domain OBJECTS
     * @param oBJECTS  The internal value that this ELEMENTValue will get
     * @return         The created value
     */
    public static ELEMENTValue create(OBJECTS oBJECTS)
    {
        Object[] edma_pair = new Object[2];
        edma_pair[0] = 0;
        edma_pair[1] = ((IValueInstance) oBJECTS).edma_getValue();
        return new ELEMENTValueImpl(edma_pair);
    }

    /**
     * Creates a new ELEMENTValue with the internal value domain JObject
     * @param jObject  The internal value that this ELEMENTValue will get
     * @return         The created value
     */
    public static ELEMENTValue create(JObject jObject)
    {
        Object[] edma_pair = new Object[2];
        edma_pair[0] = 1;
        edma_pair[1] = ((IValueInstance) jObject).edma_getValue();
        return new ELEMENTValueImpl(edma_pair);
    }

    /**
     * Creates a new ELEMENTValue with the internal value domain JSONString
     * @param jSONString  The internal value that this ELEMENTValue will get
     * @return            The created value
     */
    public static ELEMENTValue create(JSONString jSONString)
    {
        Object[] edma_pair = new Object[2];
        edma_pair[0] = 2;
        edma_pair[1] = ((IValueInstance) jSONString).edma_getValue();
        return new ELEMENTValueImpl(edma_pair);
    }

    /**
     * Creates a new ELEMENTValue with the internal value domain JSONNumber
     * @param jSONNumber  The internal value that this ELEMENTValue will get
     * @return            The created value
     */
    public static ELEMENTValue create(JSONNumber jSONNumber)
    {
        Object[] edma_pair = new Object[2];
        edma_pair[0] = 3;
        edma_pair[1] = ((IValueInstance) jSONNumber).edma_getValue();
        return new ELEMENTValueImpl(edma_pair);
    }

    /**
     * Creates a new ELEMENTValue with the internal value domain JSONFloat
     * @param jSONFloat  The internal value that this ELEMENTValue will get
     * @return           The created value
     */
    public static ELEMENTValue create(JSONFloat jSONFloat)
    {
        Object[] edma_pair = new Object[2];
        edma_pair[0] = 4;
        edma_pair[1] = ((IValueInstance) jSONFloat).edma_getValue();
        return new ELEMENTValueImpl(edma_pair);
    }

    /**
     * Creates a new ELEMENTValue with the internal value domain JSONBoolean
     * @param jSONBoolean  The internal value that this ELEMENTValue will get
     * @return             The created value
     */
    public static ELEMENTValue create(JSONBoolean jSONBoolean)
    {
        Object[] edma_pair = new Object[2];
        edma_pair[0] = 5;
        edma_pair[1] = ((IValueInstance) jSONBoolean).edma_getValue();
        return new ELEMENTValueImpl(edma_pair);
    }

    /**
     * Creates a new ELEMENTValue with the internal value domain JSONNull
     * @param jSONNull  The internal value that this ELEMENTValue will get
     * @return          The created value
     */
    public static ELEMENTValue create(JSONNull jSONNull)
    {
        Object[] edma_pair = new Object[2];
        edma_pair[0] = 6;
        edma_pair[1] = ((IValueInstance) jSONNull).edma_getValue();
        return new ELEMENTValueImpl(edma_pair);
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * OBJECTS
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          OBJECTS
     */
    public abstract boolean isOBJECTS();

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * JObject
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          JObject
     */
    public abstract boolean isJObject();

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * JSONString
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          JSONString
     */
    public abstract boolean isJSONString();

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * JSONNumber
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          JSONNumber
     */
    public abstract boolean isJSONNumber();

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * JSONFloat
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          JSONFloat
     */
    public abstract boolean isJSONFloat();

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * JSONBoolean
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          JSONBoolean
     */
    public abstract boolean isJSONBoolean();

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * JSONNull
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          JSONNull
     */
    public abstract boolean isJSONNull();

    /**
     * Returns this value as a value from the value domain OBJECTS or throws an
     * UnsupportedOperationException if this value is not from the value domain
     * OBJECTS
     * @return  This value as a value from the value domain OBJECTS
     */
    public abstract OBJECTS asOBJECTS();

    /**
     * Returns this value as a value from the value domain JObject or throws an
     * UnsupportedOperationException if this value is not from the value domain
     * JObject
     * @return  This value as a value from the value domain JObject
     */
    public abstract JObject asJObject();

    /**
     * Returns this value as a value from the value domain JSONString or throws
     * an UnsupportedOperationException if this value is not from the value
     * domain JSONString
     * @return  This value as a value from the value domain JSONString
     */
    public abstract JSONString asJSONString();

    /**
     * Returns this value as a value from the value domain JSONNumber or throws
     * an UnsupportedOperationException if this value is not from the value
     * domain JSONNumber
     * @return  This value as a value from the value domain JSONNumber
     */
    public abstract JSONNumber asJSONNumber();

    /**
     * Returns this value as a value from the value domain JSONFloat or throws
     * an UnsupportedOperationException if this value is not from the value
     * domain JSONFloat
     * @return  This value as a value from the value domain JSONFloat
     */
    public abstract JSONFloat asJSONFloat();

    /**
     * Returns this value as a value from the value domain JSONBoolean or
     * throws an UnsupportedOperationException if this value is not from the
     * value domain JSONBoolean
     * @return  This value as a value from the value domain JSONBoolean
     */
    public abstract JSONBoolean asJSONBoolean();

    /**
     * Returns this value as a value from the value domain JSONNull or throws
     * an UnsupportedOperationException if this value is not from the value
     * domain JSONNull
     * @return  This value as a value from the value domain JSONNull
     */
    public abstract JSONNull asJSONNull();
}
