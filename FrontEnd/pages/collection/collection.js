// pages/collection/collection.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    collectionList: [],
    total: 0
  },

  // 导航到图书详情
  navigateBook(e){
    wx.navigateTo({
      url: '/pages/book/book',
      success: function(res) {
        // 通过eventChannel向被打开页面传送数据
        res.eventChannel.emit('acceptDataFromOpenerPage', {bookID: e.currentTarget.dataset})
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.getCollectionList()
  },

  // 获取收藏书籍
  getCollectionList(){
    wx.request({
      url: 'http://localhost:8080/user/showCollection',
      method: 'GET',
      data: {
        userID: getApp().globalData.userID
      },
      success: (res) =>{
        this.setData({
          collectionList: res.data,
          total: res.data.length
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {
    this.getCollectionList()
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})