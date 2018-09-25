package com.shekhargulati.app.hyperon.demo.motor.adapter;

import com.shekhargulati.app.hyperon.demo.motor.domain.Option;
import pl.decerto.hyperon.ext.adapter.Adapter;
import pl.decerto.hyperon.ext.adapter.CollectionAdapter;
import pl.decerto.hyperon.ext.adapter.Mapping;

public class OptionAdapter extends Adapter {

    private Option option;

    public OptionAdapter(Option option) {
        this.option = option;
    }

    @Override
    public Mapping getMapping() {
        return new Mapping()
                .add("code", option.getCode())
                .add("coverages", new CollectionAdapter(option.getCoverages(), CoverageAdapter.class))
                .add("quote", new QuoteAdapter(option.getQuote()));
    }

}
