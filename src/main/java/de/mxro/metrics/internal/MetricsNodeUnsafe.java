package de.mxro.metrics.internal;

import java.util.Map;

import com.codahale.metrics.Meter;

import de.mxro.metrics.MetricsNode;

/**
 * A non-thread safe implementation of {@link MetricsNode}
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public class MetricsNodeUnsafe implements MetricsNode {

    Map<String, Object> metrics;

    @SuppressWarnings("unchecked")
    private <T> T assertType(final String id, final Class<T> type) {
        final Object object = metrics.get(id);

        if (!(object.getClass().equals(type))) {
            throw new RuntimeException("Id " + id + " is assigned the incompatible metrics type [" + object.getClass()
                    + "]. Expected: " + type);
        }

        return (T) object;
    }

    @Override
    public void meter(final String id) {
        final Meter meter = assertType(id, Meter.class);

        meter.mark();
    }

    public MetricsNodeUnsafe() {
        super();

    }

}