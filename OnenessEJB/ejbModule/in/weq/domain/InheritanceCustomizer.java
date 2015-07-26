/**
 * 
 */
package in.weq.domain;

import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;

/**
 * @author Paddy
 *
 */
public class InheritanceCustomizer implements DescriptorCustomizer{

    @Override
    public void customize(ClassDescriptor descriptor) throws Exception {
        descriptor.setHasMultipleTableConstraintDependecy(true);
    }
}