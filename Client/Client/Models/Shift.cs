using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;

namespace Client.Models
{
    public class Shift
    {
        [JsonPropertyName("username")]
        [NotNull]
        public string UserName { get; set; }

        [JsonPropertyName("_id")] public ObjectIDGenerator ShiftId { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("companyName")]
        public string CompanyName { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("jobTitle")]
        public string JobTitle { get; set; }

        [Required]
        [NotNull]
        [JsonPropertyName("startDate")]
        public DateTime StartDate { get; set; } = DateTime.Now;  
        
        [Required]
        [NotNull]
        [JsonPropertyName("endDate")]
        public DateTime EndDate { get; set; } = DateTime.Now;
        
        [Required, MaxLength(70)]
        [JsonPropertyName("description")] [NotNull]
        public string Description { get; set; }

        [MaxLength(70)]
        [JsonPropertyName("requirements")] [NotNull]
        public string Requirements { get; set; }

        [Required]
        [JsonPropertyName("hourWage")] [NotNull]
        public float HourWage { get; set; }
        
        
        [JsonPropertyName("pendingList")]
        public IList<String> Pending { get; set; }
        
        [JsonPropertyName("approvedList")]
        public IList<String> Approved { get; set; } 
        
        [JsonPropertyName("rejectedList")]
        public IList<String> Rejected { get; set; } 

        public override string ToString()
        {
            string s = "";
            s += UserName + " ";
            s += CompanyName + " ";
            s += JobTitle + " ";
            s += StartDate + " ";
            s += EndDate + " ";
            s += HourWage + " ";
            s += Description + " ";
            s += Requirements + " ";
            s += Pending + " ";
            s += Approved + " ";
            s += Rejected + " ";
            return s;
        }
    }
}