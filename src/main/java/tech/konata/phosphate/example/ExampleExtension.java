package tech.konata.phosphate.example;

import tech.konata.phosphate.api.Extension;
import tech.konata.phosphate.api.PApi;
import tech.konata.phosphate.example.module.ExampleModule;

/**
 * @author IzumiiKonata
 * Date: 2025/1/27 21:26
 */
public class ExampleExtension extends Extension {

    @Override
    public void onLoad(PApi pApi) {
        System.out.println("Example extension is loaded!");

        // 注册模块
        pApi.registerModule(new ExampleModule());
    }

    @Override
    public void onStop(PApi pApi) {
        System.out.println("Example extension is unloaded!");
    }

    @Override
    public String getName() {
        return "Example Extension";
    }

    @Override
    public String getVersion() {
        return "Version number goes here";
    }
}
