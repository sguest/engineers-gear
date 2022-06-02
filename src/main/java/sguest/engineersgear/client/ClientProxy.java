package sguest.engineersgear.client;

import sguest.engineersgear.common.CommonProxy;

public class ClientProxy extends CommonProxy {
    @Override
    public void loadComplete() {
        Manual.init();
    }
}
