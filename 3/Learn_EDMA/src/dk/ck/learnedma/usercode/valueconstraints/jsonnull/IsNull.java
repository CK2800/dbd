package dk.ck.learnedma.usercode.valueconstraints.jsonnull;

import dk.ck.learnedma.generated.valuedomains.JSONNull;

/**
 * This class is the implementation class for the JSONNull constraint isNull
 * No description given
 */
public class IsNull
{



    /**
     * Checks the isNull constraint for the JSONNull value domain.
     * No description given
     * @param jSONNull  The instance value to be checked
     * @return          the reason the constraint is violated, or <tt>null</tt>
     *                  if the constraint is not violated
     */
    public static String checkIsNull(JSONNull jSONNull)
    {
        // Implementation of constraint isNull
        // WARNING : Any code outside the following begin and end tags
        // will be lost when re-generation occurs.
        
        // EDMA_non-generated_code_begin
        
        return jSONNull.value() == "null" ? null : "The provided string must be 'null', not " + jSONNull.value();
        
        // EDMA_non-generated_code_end
    }


}
