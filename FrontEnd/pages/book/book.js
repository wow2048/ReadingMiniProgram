// pages/book/book.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    //以下为默认数据，方便显示未与数据库连接时的测试
    bookID: "",
    isCollected: false,
    bookImage: "",
    bookName: "",
    writer: "",
    publisher: "",
    publishDate: "",
    brief: ""
  },

  collectingHandler(e){
    if (this.data.isCollected) {
      //如果已收藏，则取消收藏
      this.setData({
        isCollected: false
      })
      wx.request({
        url: 'http://localhost:8080/user/removeCollection',
        method:'GET',
        data: {
          userID: getApp().globalData.userID,
          bookID: this.data.bookID,
        },
      })

    }else{
      //如果未收藏，则添加为收藏
      this.setData({
        isCollected: true
      })
      wx.request({
        url: 'http://localhost:8080/user/addCollection',
        method:'GET',
        data: {
          userID: getApp().globalData.userID,
          bookID: this.data.bookID,
        },
      })
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    //获取上一页传入的bookID
    // 此处有待修改，需要前一个页面的数据名称以及userID的处理
    const eventChannel = this.getOpenerEventChannel()
    // 监听acceptDataFromOpenerPage事件，获取上一页面通过eventChannel传送到当前页面的数据
    eventChannel.on('acceptDataFromOpenerPage', (data) => {
      this.setData({
        bookID: data.bookID.bookid
      })
      this.getBook(data)
    })
  },

  getBook(data){
    //获取书籍信息
    wx.request({
      url: 'http://localhost:8080/book/getBook',
      method:'GET',
      data: {
        bookID: data.bookID.bookid,
      },
      success:(res)=>{
        this.setData({
          bookName: res.data.name,
          writer: res.data.author,
          publisher: res.data.publisher,
          publishDate: res.data.publishingTime,
          bookImage: res.data.imageBase64,
          brief: res.data.brief
        })
      }
    })

    //访问后端提供userID和bookID，来得知书籍是否已经收藏
    wx.request({
      url: 'http://localhost:8080/book/isCollected',
      method:'GET',
      data: {
        userID: getApp().globalData.userID,
        bookID: data.bookID.bookid
      },
      success:(res)=>{
        console.log(res.data)
        this.setData({
          isCollected: res.data
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