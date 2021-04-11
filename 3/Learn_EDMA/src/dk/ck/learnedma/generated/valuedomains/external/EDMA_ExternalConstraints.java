package dk.ck.learnedma.generated.valuedomains.external;

import dk.ck.learnedma.generated.valuedomains.JSONNull;
import dk.ck.learnedma.generated.valuedomains.MyInt;
import dk.ck.learnedma.generated.valuedomains.impl.JSONNullImpl;
import dk.ck.learnedma.generated.valuedomains.impl.MyIntImpl;
import dk.ck.learnedma.usercode.valueconstraints.jsonnull.IsNull;
import dk.ck.learnedma.usercode.valueconstraints.myint.IsEven;
import org.abstractica.edma.util.Pair;
import org.abstractica.edma.valuedomains.IExternalConstraints;

/**
 * 
 */
public class EDMA_ExternalConstraints implements IExternalConstraints
{
    public static final IExternalConstraints instance = new EDMA_ExternalConstraints();



    /**
     * Constructor
     */
    public EDMA_ExternalConstraints()
    {
        
    }

    /**
     * check external constraints
     * @param edma_obj    The value object to check
     * @param edma_index  Value domain index
     * @return            A pair of the index of the first constraint that is
     *                    violated and the error message or <tt>null</tt> if no
     *                    constraints are violated
     */
    public Pair<Integer, String> checkConstraints(Object edma_obj, int edma_index)
    {
        switch(edma_index)
        {
            case 0:
            {
                MyInt myInt = new MyIntImpl(edma_obj);
                String edma_reason;
                edma_reason = IsEven.checkIsEven(myInt);
                if(edma_reason != null) return new Pair<Integer, String>(0, edma_reason);
                return null;
            }
            case 6:
            {
                JSONNull jSONNull = new JSONNullImpl(edma_obj);
                String edma_reason;
                edma_reason = IsNull.checkIsNull(jSONNull);
                if(edma_reason != null) return new Pair<Integer, String>(0, edma_reason);
                return null;
            }
            default :
                throw new RuntimeException("Internal Error!");
        }
    }
}
