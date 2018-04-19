import React, { Component } from "react";
import logo from "./logo.svg";
import "./App.css";
import brace from "brace";
import { monokai } from "brace/theme/monokai";
import { github } from "brace/theme/github";
import "brace/mode/java";
import AceEditor from "react-ace";
import { tryCatchFinally, tooltips } from "./FileReaderExamples";
import beautify from "js-beautify";
import "antd/dist/antd.css";
import { Form, Icon, Input, Button, Checkbox } from "antd";
import { filterOptions, taggedSnippets } from "./data";
class App extends Component {
  state = {
    codeShown: false
  };

  toggle = () => {
    const { codeShown } = this.state;
    this.setState({ codeShown: !codeShown });
  };

  handleOnChange = newVal => {};

  render() {
    console.log(taggedSnippets);
    const codeData = beautify(tryCatchFinally, { indent_size: 2 });
    return (
      <div className="App">
        <button onClick={this.toggle}>Show Code</button>
        {this.state.codeShown && (
          <AceEditor
            mode="java"
            theme="monokai"
            onChange={this.handleOnChange}
            name="UNIQUE_ID_OF_DIV"
            defaultValue={codeData}
          />
        )}
      </div>
    );
  }
}

export default App;
