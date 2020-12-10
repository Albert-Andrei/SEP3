#pragma checksum "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "8017dd81977a21b43fb4e8a631b89966ac2be998"
// <auto-generated/>
#pragma warning disable 1591
namespace Client.Pages
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using Client;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using Client.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
using Client.Data;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
using Client.Models;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/sign-up")]
    public partial class SignUpComponent : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
            __builder.OpenComponent<Microsoft.AspNetCore.Components.Forms.EditForm>(0);
            __builder.AddAttribute(1, "Model", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Object>(
#nullable restore
#line 8 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                  newUser

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(2, "OnValidSubmit", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<Microsoft.AspNetCore.Components.Forms.EditContext>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Forms.EditContext>(this, 
#nullable restore
#line 8 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                           CreateNewUser

#line default
#line hidden
#nullable disable
            )));
            __builder.AddAttribute(3, "ChildContent", (Microsoft.AspNetCore.Components.RenderFragment<Microsoft.AspNetCore.Components.Forms.EditContext>)((context) => (__builder2) => {
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.DataAnnotationsValidator>(4);
                __builder2.CloseComponent();
                __builder2.AddMarkupContent(5, "\r\n\r\n    ");
                __builder2.OpenElement(6, "div");
                __builder2.AddAttribute(7, "class", "sign-up");
                __builder2.AddMarkupContent(8, @"<div class=""auth-sidebar""><div class=""auth-sidebar-content""><div class=""header""><a href=""/"" class=""signup-logo"">Logo</a>
                    <h1>Discover all available possibilities of our platform</h1></div></div></div>

        <div class=""calhoz""></div>

        ");
                __builder2.OpenElement(9, "div");
                __builder2.AddAttribute(10, "class", "content");
                __builder2.OpenElement(11, "main");
                __builder2.OpenElement(12, "div");
                __builder2.AddAttribute(13, "class", "auth-content");
                __builder2.AddMarkupContent(14, "<h2>Sign up to JPool</h2>\r\n\r\n                    <hr class=\"divider\">\r\n\r\n                    ");
                __builder2.OpenElement(15, "div");
                __builder2.AddAttribute(16, "class", "forms");
                __builder2.AddAttribute(17, "autocomplete", "on");
                __builder2.OpenElement(18, "div");
                __builder2.AddAttribute(19, "class", "name");
                __builder2.OpenElement(20, "div");
                __builder2.AddAttribute(21, "class", "box");
                __builder2.OpenElement(22, "fieldset");
                __builder2.AddMarkupContent(23, "<label>Username</label>\r\n                                    ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(24);
                __builder2.AddAttribute(25, "autocomplete", "email");
                __builder2.AddAttribute(26, "class", "text-input");
                __builder2.AddAttribute(27, "type", "text");
                __builder2.AddAttribute(28, "name", "email");
                __builder2.AddAttribute(29, "oninput", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.ChangeEventArgs>(this, 
#nullable restore
#line 38 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                                      (arg) => change(arg)

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(30, "required", true);
                __builder2.AddAttribute(31, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 39 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                            newUser.UserName

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(32, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => newUser.UserName = __value, newUser.UserName))));
                __builder2.AddAttribute(33, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => newUser.UserName));
                __builder2.CloseComponent();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(34, "\r\n                                ");
                __Blazor.Client.Pages.SignUpComponent.TypeInference.CreateValidationMessage_0(__builder2, 35, 36, 
#nullable restore
#line 41 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                          () => newUser.UserName

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.AddMarkupContent(37, "\r\n                            ");
                __builder2.OpenElement(38, "div");
                __builder2.AddAttribute(39, "class", "dropdown-state");
                __builder2.AddMarkupContent(40, "<label for=\"state\">Status:</label>\r\n                                ");
                __builder2.OpenElement(41, "select");
                __builder2.AddAttribute(42, "name", "type");
                __builder2.AddAttribute(43, "class", "state");
                __builder2.AddAttribute(44, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 45 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                                          selectedType

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(45, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => selectedType = __value, selectedType));
                __builder2.SetUpdatesAttributeName("value");
#nullable restore
#line 46 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                     foreach (var t in type)
                                    {

#line default
#line hidden
#nullable disable
                __builder2.OpenElement(46, "option");
                __builder2.AddAttribute(47, "value", 
#nullable restore
#line 48 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                       t

#line default
#line hidden
#nullable disable
                );
                __builder2.AddContent(48, 
#nullable restore
#line 48 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                          t

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
#nullable restore
#line 49 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                    }

#line default
#line hidden
#nullable disable
                __builder2.CloseElement();
                __builder2.AddMarkupContent(49, "\r\n                                ");
                __Blazor.Client.Pages.SignUpComponent.TypeInference.CreateValidationMessage_1(__builder2, 50, 51, 
#nullable restore
#line 51 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                          () => newUser.UserType

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(52, "\r\n\r\n                        ");
                __builder2.OpenElement(53, "div");
                __builder2.AddAttribute(54, "class", "name");
                __builder2.OpenElement(55, "div");
                __builder2.AddAttribute(56, "class", "box");
                __builder2.OpenElement(57, "fieldset");
                __builder2.AddMarkupContent(58, "<label>Password</label>\r\n                                    ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(59);
                __builder2.AddAttribute(60, "placeholder", "8+ characters ");
                __builder2.AddAttribute(61, "class", "text-input");
                __builder2.AddAttribute(62, "type", "password");
                __builder2.AddAttribute(63, "oninput", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.ChangeEventArgs>(this, 
#nullable restore
#line 60 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                                         (arg) => change(arg)

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(64, "required", true);
                __builder2.AddAttribute(65, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 61 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                            newUser.Password

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(66, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => newUser.Password = __value, newUser.Password))));
                __builder2.AddAttribute(67, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => newUser.Password));
                __builder2.CloseComponent();
                __builder2.AddMarkupContent(68, "\r\n                                    ");
                __Blazor.Client.Pages.SignUpComponent.TypeInference.CreateValidationMessage_2(__builder2, 69, 70, 
#nullable restore
#line 62 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                              () => newUser.Password

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(71, "\r\n                            ");
                __builder2.OpenElement(72, "div");
                __builder2.AddAttribute(73, "class", "box");
                __builder2.OpenElement(74, "fieldset");
                __builder2.AddMarkupContent(75, "<label>Confirm password</label>\r\n                                    ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(76);
                __builder2.AddAttribute(77, "placeholder", "8+ characters ");
                __builder2.AddAttribute(78, "class", "text-input");
                __builder2.AddAttribute(79, "type", "password");
                __builder2.AddAttribute(80, "oninput", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.ChangeEventArgs>(this, 
#nullable restore
#line 69 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                                         (arg) => change(arg)

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(81, "required", true);
                __builder2.AddAttribute(82, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 70 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                            PasswordToCheck

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(83, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => PasswordToCheck = __value, PasswordToCheck))));
                __builder2.AddAttribute(84, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => PasswordToCheck));
                __builder2.CloseComponent();
                __builder2.AddMarkupContent(85, "\r\n                                    ");
                __Blazor.Client.Pages.SignUpComponent.TypeInference.CreateValidationMessage_3(__builder2, 86, 87, 
#nullable restore
#line 71 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                              () => newUser.Password

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(88, "\r\n\r\n                        ");
                __builder2.OpenElement(89, "div");
                __builder2.AddAttribute(90, "class", "name");
                __builder2.OpenElement(91, "div");
                __builder2.AddAttribute(92, "class", "box");
                __builder2.OpenElement(93, "fieldset");
                __builder2.AddMarkupContent(94, "<label>First Name</label>\r\n                                    ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(95);
                __builder2.AddAttribute(96, "autocomplete", "given-name");
                __builder2.AddAttribute(97, "class", "text-input");
                __builder2.AddAttribute(98, "type", "text");
                __builder2.AddAttribute(99, "name", "given-name");
                __builder2.AddAttribute(100, "required", true);
                __builder2.AddAttribute(101, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 82 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                            newUser.FirstName

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(102, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => newUser.FirstName = __value, newUser.FirstName))));
                __builder2.AddAttribute(103, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => newUser.FirstName));
                __builder2.CloseComponent();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(104, "\r\n                            ");
                __builder2.OpenElement(105, "div");
                __builder2.AddAttribute(106, "class", "box");
                __builder2.OpenElement(107, "fieldset");
                __builder2.AddMarkupContent(108, "<label>Last Name</label>\r\n                                    ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(109);
                __builder2.AddAttribute(110, "autocomplete", "family-name");
                __builder2.AddAttribute(111, "class", "text-input");
                __builder2.AddAttribute(112, "type", "text");
                __builder2.AddAttribute(113, "name", "family-name");
                __builder2.AddAttribute(114, "required", true);
                __builder2.AddAttribute(115, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 90 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                            newUser.LastName

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(116, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => newUser.LastName = __value, newUser.LastName))));
                __builder2.AddAttribute(117, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => newUser.LastName));
                __builder2.CloseComponent();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(118, "\r\n\r\n                        ");
                __builder2.OpenElement(119, "div");
                __builder2.AddAttribute(120, "class", "longbox");
                __builder2.AddAttribute(121, "autocomplete", "On");
                __builder2.OpenElement(122, "div");
                __builder2.AddAttribute(123, "class", "email");
                __builder2.OpenElement(124, "fieldset");
                __builder2.AddMarkupContent(125, "<label>Email</label>\r\n                                    ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(126);
                __builder2.AddAttribute(127, "autocomplete", "email");
                __builder2.AddAttribute(128, "class", "text-input");
                __builder2.AddAttribute(129, "type", "text");
                __builder2.AddAttribute(130, "name", "email");
                __builder2.AddAttribute(131, "required", true);
                __builder2.AddAttribute(132, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 100 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                                         newUser.Email

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(133, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => newUser.Email = __value, newUser.Email))));
                __builder2.AddAttribute(134, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => newUser.Email));
                __builder2.CloseComponent();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(135, "\r\n                    ");
                __builder2.OpenElement(136, "div");
                __builder2.AddAttribute(137, "style", "color:red");
                __builder2.AddContent(138, 
#nullable restore
#line 105 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                            errorMessage

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.AddMarkupContent(139, "\r\n                    ");
                __builder2.OpenElement(140, "button");
                __builder2.AddAttribute(141, "type", "button");
                __builder2.AddAttribute(142, "class", "signupBtn");
                __builder2.AddAttribute(143, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 106 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
                                                                      PerformCreate

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddContent(144, "Create Account");
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
            }
            ));
            __builder.CloseComponent();
        }
        #pragma warning restore 1998
#nullable restore
#line 113 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Pages\SignUpComponent.razor"
       
    private string errorMessage;
    private string PasswordToCheck;
    private User newUser = new User();
    List<string> type = new List<string>() {"Employee", "Employer"};
    string selectedType = "Employee";

    public async Task PerformCreate()
    {
        try
        {
            if (!PasswordToCheck.Equals(newUser.Password))
            {
                errorMessage = "Passwords don't match";
            }
            else
            {
                errorMessage = "";
                await CreateNewUser();
            }
        }
        catch (Exception e)
        {
            errorMessage = "";
            Console.WriteLine(e);
            throw;
        }
    }

    private void change(ChangeEventArgs changeEventArgs)
    {
        if (!string.IsNullOrEmpty(changeEventArgs.Value.ToString()))
        {
            errorMessage = "";
        }
    }

    private async Task CreateNewUser()
    {
        newUser.UserType = selectedType;
        try
        {
            await UserService.CreateUserAsync(newUser);
            NavigationManager.NavigateTo("/log-in");
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            errorMessage = e.Message;
        }
    }


#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private IUserService UserService { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private NavigationManager NavigationManager { get; set; }
    }
}
namespace __Blazor.Client.Pages.SignUpComponent
{
    #line hidden
    internal static class TypeInference
    {
        public static void CreateValidationMessage_0<TValue>(global::Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder, int seq, int __seq0, global::System.Linq.Expressions.Expression<global::System.Func<TValue>> __arg0)
        {
        __builder.OpenComponent<global::Microsoft.AspNetCore.Components.Forms.ValidationMessage<TValue>>(seq);
        __builder.AddAttribute(__seq0, "For", __arg0);
        __builder.CloseComponent();
        }
        public static void CreateValidationMessage_1<TValue>(global::Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder, int seq, int __seq0, global::System.Linq.Expressions.Expression<global::System.Func<TValue>> __arg0)
        {
        __builder.OpenComponent<global::Microsoft.AspNetCore.Components.Forms.ValidationMessage<TValue>>(seq);
        __builder.AddAttribute(__seq0, "For", __arg0);
        __builder.CloseComponent();
        }
        public static void CreateValidationMessage_2<TValue>(global::Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder, int seq, int __seq0, global::System.Linq.Expressions.Expression<global::System.Func<TValue>> __arg0)
        {
        __builder.OpenComponent<global::Microsoft.AspNetCore.Components.Forms.ValidationMessage<TValue>>(seq);
        __builder.AddAttribute(__seq0, "For", __arg0);
        __builder.CloseComponent();
        }
        public static void CreateValidationMessage_3<TValue>(global::Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder, int seq, int __seq0, global::System.Linq.Expressions.Expression<global::System.Func<TValue>> __arg0)
        {
        __builder.OpenComponent<global::Microsoft.AspNetCore.Components.Forms.ValidationMessage<TValue>>(seq);
        __builder.AddAttribute(__seq0, "For", __arg0);
        __builder.CloseComponent();
        }
    }
}
#pragma warning restore 1591
