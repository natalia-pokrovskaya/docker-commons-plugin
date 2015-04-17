package org.jenkinsci.plugins.docker.commons;

import com.cloudbees.plugins.credentials.domains.DomainRequirement;
import com.cloudbees.plugins.credentials.domains.DomainSpecification;
import com.cloudbees.plugins.credentials.domains.DomainSpecificationDescriptor;
import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;

/**
 * A {@link DomainSpecification} that allows users to identify credential domains that are for use against docker 
 * server instances.
 *
 * @author Stephen Connolly
 */
public class DockerServerDomainSpecification extends DomainSpecification {
    /** {@inheritDoc} */
    @NonNull
    @Override
    public Result test(DomainRequirement scope) {
        if (scope instanceof DockerServerDomainRequirement) {
            // we are a very simple specification
            return Result.POSITIVE;
        }
        return Result.UNKNOWN;
    }

    /** {@inheritDoc} */
    @Extension
    public static class DescriptorImpl extends DomainSpecificationDescriptor {

        @Override
        public String getDisplayName() {
            return Messages.DockerServerDomainSpecification_DisplayName();
        }
    }
}
