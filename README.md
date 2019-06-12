## dawn-design-pattern
整理设计模式 开源代码的例子 自己写过的一些设计


### 责任链 & 功能链
#### 1、内部链 
  > 最单纯的责任链，每个处理节点拥有下一个处理节点或者结束处理，常用于解耦复杂的if-else逻辑  
  > package: `knight.su.dawn.chain.inner_chain`  
  > demo: 对用户类型判断，进行相对应的处理, InnerChainHandlerMain类隐藏处理节点之间的关联  
  > [`InnerChainHandlerTest`](https://github.com/knightdawn/dawn-design-pattern/tree/master/src/main/java/knight/su/dawn/chain/inner_chain/InnerChainHandlerTest.java)  
  
#### 2、外部链
  > 责任链变形，根据数据的特性划分归类多种类型的操作, 通过链串起所有操作  
  > package: `knight.su.dawn.chain.external_chain`  
  > demo: 对数据进行校验，划分设备、用户、版本进行校验，可以动态增删校验动作  
  > [`CheckTest`](https://github.com/knightdawn/dawn-design-pattern/tree/master/src/main/java/knight/su/dawn/chain/external_chain/CheckTest.java)  
  
#### 3、双向链（Filter Chain）  
  > 常出现与请求的处理，对Request和Response进行串联过滤处理，容器web的常见设计   
  > package: `knight.su.dawn.chain.filter_chain`  
  > demo: 对请求响应进行日志记录和字符过滤处理的例子  
  > [`FilterChainTest`](https://github.com/knightdawn/dawn-design-pattern/tree/master/src/main/java/knight/su/dawn/chain/filter_chain/FilterChainTest.java)  
  
#### 4、每个环节处理一部分
  > 这个是对于2的扩展，针对一组数据，拆分操作，通过链串起操作  
  > package: `knight.su.dawn.chain.part_chain`  
  > demo: 对一组数据输入，进行格式处理、全局字段处理、空值处理  
  > [`PartialActionTest`](https://github.com/knightdawn/dawn-design-pattern/tree/master/src/main/java/knight/su/dawn/chain/part_chain/PartialActionTest.java) 
   
#### 5、每个环节处理结果作为下一个环节输入参数
  > 这个是对于4的扩展，针对一组数据，每个环节处理一部分数据，剩余数据由下环节处理，中间可利用输出消费者消费处理后的数据  
  > package: `knight.su.dawn.chain.input_output_chain`  
  > demo: 获取经纬度的例子，优先从缓存中获取，缓存不存在的数据，从服务A获取，服务B作为兜底服务  
  > [`IOChainTest`](https://github.com/knightdawn/dawn-design-pattern/tree/master/src/main/java/knight/su/dawn/chain/input_output_chain/IOChainTest.java)  

### 访问者

#### asm 
  > Java8里面已经集成了ASM字节码框架api，里面的设计就是典型的访问者模式
  > 具体使用例子（asm字节码修改class文件，添加方法的响应时间日志记录）
  > 见 AsmTest   
#### 业务demo
