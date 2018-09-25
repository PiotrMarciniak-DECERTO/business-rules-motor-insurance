package com.shekhargulati.app.hyperon.demo.motor.adapter;

import com.shekhargulati.app.hyperon.demo.motor.domain.Coverage;
import pl.decerto.hyperon.ext.adapter.Adapter;
import pl.decerto.hyperon.ext.adapter.Mapping;

public class CoverageAdapter extends Adapter {

    private Coverage coverage;

    public CoverageAdapter(Coverage coverage) {
        this.coverage = coverage;
    }

    @Override
    public Mapping getMapping() {
        return new Mapping()

                // simple types (model leaves)
                .add("code", coverage.getCode())
                .add("limit1", coverage.getLimit1())
                .add("limit2", coverage.getLimit2())
                .add("premium", coverage.getPremium())

                // parent option (there is exactly one parent option)
                .add("option", new OptionAdapter(coverage.getOption()))

                // parent quote (there is exactly one parent quote)
                .add("quote", new QuoteAdapter(coverage.getQuote()));
    }

}
