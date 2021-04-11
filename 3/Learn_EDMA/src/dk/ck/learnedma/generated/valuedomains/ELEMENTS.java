package dk.ck.learnedma.generated.valuedomains;

import dk.ck.learnedma.generated.LearnEDMA;
import dk.ck.learnedma.generated.valuedomains.external.EDMA_ExternalConstraints;
import dk.ck.learnedma.generated.valuedomains.impl.ELEMENTSBuilderImpl;
import dk.ck.learnedma.generated.valuedomains.impl.ELEMENTSImpl;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: ELEMENTS
 */
public abstract class ELEMENTS implements Comparable<ELEMENTS>, Iterable<ELEMENT>
{
    protected static final IMetaValueDomain edma_domain = LearnEDMA.environment.getValueDomainDefinitions().getValueDomain(9);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The ELEMENTS from the terminal
     */
    public static ELEMENTS fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new ELEMENTSImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The ELEMENTS from the string representation
     */
    public static ELEMENTS fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new ELEMENTSImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The ELEMENTS read from the stream
     */
    public static ELEMENTS fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new ELEMENTSImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The ELEMENTS read from the stream
     */
    public static ELEMENTS fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new ELEMENTSImpl(res);
    }

    /**
     * Starts creation of a new ELEMENTS
     * @return  Builder interface to build the list
     */
    public static ELEMENTSBuilder begin()
    {
        return new ELEMENTSBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * Returns the size of this list
     * @return  the size of this list
     */
    public abstract int size();

    /**
     * Returns the element on a given index in this list
     * @param index  The index of the element to be returned
     * @return       the element on the given index in this list
     */
    public abstract ELEMENT get(int index);


    /**
     * Interface to create a list
     */
    public interface ELEMENTSBuilder
    {

        /**
         * Adds an element to the list
         * @param eLEMENT  The element to be added to the list
         * @return         An interface to the builder for chaining method calls
         */
        public ELEMENTSBuilder add(ELEMENT eLEMENT);

        /**
         * Builds the list with the added elements
         * @return  The builded list
         */
        public ELEMENTS end();

    }

}
