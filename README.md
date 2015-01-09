# Lightweight Java Metrics

A very lightweight way to report metrics for Java applications based on the [Dropwizard Metrics Project](https://dropwizard.github.io/metrics/3.1.0/).

## Counters

Keeping a count of a metric. For instance: How many users are logged into the system concurrently.

```java
MetricsNode m = Metrics.create();

m.record(Metrics.increment("counter"));
m.record(Metrics.increment("counter"));
m.record(Metrics.decrement("counter"));

m.print();

m.stop().get();
```

Should result in the output:

```
{
    'counter': '1'
}
```

## Throughput Measurement

Monitor how many times per second an event occurs. For instance: How many times per second is a service called.

```java
final MetricsNode m = Metrics.create();

m.record(Metrics.happened("process"));
m.record(Metrics.happened("process"));
m.record(Metrics.happened("process"));

Thread.sleep(10000);

m.print();

m.stop().get();
```

Should result in the output:

```
{
    'process': {
        'Total Events': '3',
        'Events per Second (last Minute)': '0.552026648777594',
        'Events per Second (last 5 Minutes)': '0.5900828722929705',
        'Events per Second (last 15 Minutes)': '0.5966759088029381'
    }
}
```

## Statistics



## Reporting

This project follows a very lightweight approach to reporting. All it does for you is turn metrics into easily human-readable strings. What you do with these is up to.


## Compatibility

This project is compatible with the following environments:

- Java 1.6+
- GWT 2.5.0+
- Android
