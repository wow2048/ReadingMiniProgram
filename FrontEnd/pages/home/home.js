// pages/home/home.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    swiperList: [
      {
        imgSrc: '/images/swiper/01introduction.jpg'
      },
      {
        imgSrc: '/images/swiper/02computerBook.png'
      },
      {
        imgSrc: '/images/swiper/03classicBook.png'
      }
    ],

    bookList: []
  },

  // navigate to page search
  navigateSearch(e){
    wx.navigateTo({
      url: '../../pages/search/search',
      success: (res) => {
        res.eventChannel.emit('acceptDataFromOpenerPage', {input: e.detail.value})
      },
    })
  },

  // navigete to page introduction
  navigateIntroduction(){
    wx.navigateTo({
      url: '../../pages/introdution/introdution',
    })
  },

  // navigate to page computorBook
  navigateComputerBook(){
    wx.navigateTo({
      url: '../../pages/computerBook/computerBook',
    })
  },

  // navigate to page classicBook
  navigateClassicBook(){
    wx.navigateTo({
      url: '../../pages/classicBook/classicBook',
    })
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

  // 获取首页图书
  getBookList() {
    wx.request({
      url: 'http://localhost:8080/book/search',
      method: 'GET',
      data: {
        information: "海"
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