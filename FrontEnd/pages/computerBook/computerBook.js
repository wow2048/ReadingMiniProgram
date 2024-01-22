// pages/computorBook/computorBook.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    bookList: []
  },

  // navigate to page book 
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
    this.getBookList()
  },

    // 获取书籍列表
  getBookList() {
    wx.request({
      url: 'http://localhost:8080/book/search',
      method: 'GET',
      data: {
        information: "计算机"
      },
      success: (res) =>{
        this.setData({
          bookList: res.data
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