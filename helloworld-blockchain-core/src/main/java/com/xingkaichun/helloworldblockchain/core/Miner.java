package com.xingkaichun.helloworldblockchain.core;

/**
 * 矿工:挖矿、将挖取的区块放入区块链
 *
 * @author 邢开春 409060350@qq.com
 */
public abstract class Miner {

    //配置
    protected CoreConfiguration coreConfiguration;
    //矿工钱包：矿工的挖矿奖励会放到钱包里。
    protected Wallet wallet;
    //矿工挖矿所在的区块链
    protected BlockchainDatabase blockchainDatabase;
    //未确认交易数据库：矿工从未确认交易数据库里获取挖矿的原材料(未确认交易数据)
    protected UnconfirmedTransactionDatabase unconfirmedTransactionDatabase;

    public Miner(CoreConfiguration coreConfiguration, Wallet wallet, BlockchainDatabase blockchainDatabase, UnconfirmedTransactionDatabase unconfirmedTransactionDatabase) {
        this.coreConfiguration = coreConfiguration;
        this.wallet = wallet;
        this.blockchainDatabase = blockchainDatabase;
        this.unconfirmedTransactionDatabase = unconfirmedTransactionDatabase;
    }


    //region 挖矿相关
    /**
     * 启用矿工。
     * 矿工有两种状态：活动状态与非活动状态。
     * 若矿工处于活动作态，矿工会进行挖矿劳作。
     * 若矿工处于非活动状态，矿工不会进行任何工作。
     */
    public abstract void start() ;

    /**
     * 矿工是否处于活动状态。
     */
    public abstract boolean isActive() ;

    /**
     * 激活矿工：设置矿工为活动状态。
     */
    public abstract void active() ;

    /**
     * 停用矿工：设置矿工为非活动状态。
     */
    public abstract void deactive() ;

    /**
     * 设置矿工可挖掘的最高区块高度
     */
    public abstract void setMaxBlockHeight(long maxHeight) ;
    /**
     * 获取矿工可挖掘的最高区块高度
     */
    public abstract long getMaxBlockHeight( ) ;

    //endregion



    //region get set


    public Wallet getWallet() {
        return wallet;
    }

    public BlockchainDatabase getBlockchainDatabase() {
        return blockchainDatabase;
    }

    public UnconfirmedTransactionDatabase getUnconfirmedTransactionDatabase() {
        return unconfirmedTransactionDatabase;
    }

    public CoreConfiguration getCoreConfiguration() {
        return coreConfiguration;
    }

    //endregion
}